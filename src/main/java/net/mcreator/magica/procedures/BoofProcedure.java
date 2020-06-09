package net.mcreator.magica.procedures;

import net.minecraft.world.World;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.magica.MagicaModVariables;
import net.mcreator.magica.MagicaModElements;

@MagicaModElements.ModElement.Tag
public class BoofProcedure extends MagicaModElements.ModElement {
	public BoofProcedure(MagicaModElements instance) {
		super(instance, 40);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Boof!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Boof!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		for (int index0 = 0; index0 < (int) (72); index0++) {
			entity.rotationYaw = (float) ((MagicaModVariables.MapVariables.get(world).Gradus));
			entity.rotationPitch = (float) (0);
			if (!world.isRemote && entity instanceof LivingEntity) {
				ArrowEntity entityToSpawn = new ArrowEntity(world, (LivingEntity) entity);
				entityToSpawn.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, (float) 1, 0);
				entityToSpawn.setDamage((float) 5);
				entityToSpawn.setKnockbackStrength((int) 5);
				world.addEntity(entityToSpawn);
			}
			MagicaModVariables.MapVariables.get(world).Gradus = (double) ((MagicaModVariables.MapVariables.get(world).Gradus) + 5);
			MagicaModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
