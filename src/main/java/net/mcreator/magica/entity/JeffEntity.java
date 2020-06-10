
package net.mcreator.magica.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.ServerBossInfo;
import net.minecraft.world.BossInfo;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.magica.procedures.JeffEntityDiesProcedure;
import net.mcreator.magica.MagicaModElements;

@MagicaModElements.ModElement.Tag
public class JeffEntity extends MagicaModElements.ModElement {
	public static EntityType entity = null;
	public JeffEntity(MagicaModElements instance) {
		super(instance, 44);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(1f, 2.5f)).build("jeff")
						.setRegistryName("jeff");
		elements.entities.add(() -> entity);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new Modeljeffph1(), 1.2000000000000002f) {
				@Override
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("magica:textures/jeffph1.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 1100;
			setNoAI(false);
			enablePersistence();
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, PlayerEntity.class, true, false));
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, ServerPlayerEntity.class, true, false));
			this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(4, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(5, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(7, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEAD;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			Entity sourceentity = source.getTrueSource();
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				JeffEntityDiesProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(250);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.PINK, BossInfo.Overlay.NOTCHED_6);
		@Override
		public void addTrackingPlayer(ServerPlayerEntity player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(ServerPlayerEntity player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void updateAITasks() {
			super.updateAITasks();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}
	}

	public static class Modeljeffph1 extends EntityModel {
		private final RendererModel RightArm;
		private final RendererModel Head;
		private final RendererModel Body;
		private final RendererModel RightLeg;
		private final RendererModel LeftLeg;
		private final RendererModel LeftArm;
		public Modeljeffph1() {
			textureWidth = 128;
			textureHeight = 128;
			RightArm = new RendererModel(this);
			RightArm.setRotationPoint(-7.0F, -6.0F, 0.0F);
			RightArm.cubeList.add(new ModelBox(RightArm, 0, 106, -5.0F, -2.0F, -3.0F, 6, 16, 6, 0.0F, false));
			Head = new RendererModel(this);
			Head.setRotationPoint(0.0F, -8.0F, -6.0F);
			Head.cubeList.add(new ModelBox(Head, 0, 0, -3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F, false));
			Body = new RendererModel(this);
			Body.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.cubeList.add(new ModelBox(Body, 0, 32, -6.0F, -8.0F, -3.0F, 12, 16, 6, 0.0F, false));
			RightLeg = new RendererModel(this);
			RightLeg.setRotationPoint(-3.0F, 10.0F, 0.0F);
			RightLeg.cubeList.add(new ModelBox(RightLeg, 104, 0, -3.0F, -2.0F, -3.0F, 6, 16, 6, 0.0F, false));
			LeftLeg = new RendererModel(this);
			LeftLeg.setRotationPoint(3.0F, 10.0F, 0.0F);
			LeftLeg.cubeList.add(new ModelBox(LeftLeg, 104, 0, -3.0F, -2.0F, -3.0F, 6, 16, 6, 0.0F, false));
			LeftArm = new RendererModel(this);
			LeftArm.setRotationPoint(7.0F, -6.3333F, 0.0F);
			LeftArm.cubeList.add(new ModelBox(LeftArm, 96, 91, 3.0F, 4.3333F, -4.0F, 8, 12, 8, 0.0F, false));
			LeftArm.cubeList.add(new ModelBox(LeftArm, 104, 56, 4.0F, 2.3333F, -3.0F, 6, 16, 6, 0.0F, false));
			LeftArm.cubeList.add(new ModelBox(LeftArm, 92, 116, -2.0F, -2.6667F, -3.0F, 12, 6, 6, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			RightArm.render(f5);
			Head.render(f5);
			Body.render(f5);
			RightLeg.render(f5);
			LeftLeg.render(f5);
			LeftArm.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
			super.setRotationAngles(e, f, f1, f2, f3, f4, f5);
			this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
