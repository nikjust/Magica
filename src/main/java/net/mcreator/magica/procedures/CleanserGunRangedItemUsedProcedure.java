package net.mcreator.magica.procedures;

import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.magica.item.MagicaWandItem;
import net.mcreator.magica.MagicaModElements;

import java.util.Random;

@MagicaModElements.ModElement.Tag
public class CleanserGunRangedItemUsedProcedure extends MagicaModElements.ModElement {
	public CleanserGunRangedItemUsedProcedure(MagicaModElements instance) {
		super(instance, 38);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure CleanserGunRangedItemUsed!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CleanserGunRangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		for (int index0 = 0; index0 < (int) (10); index0++) {
			if (!world.isRemote && entity instanceof LivingEntity) {
				MagicaWandItem.shoot(world, (LivingEntity) entity, new Random(), 1, (float) 5, (int) 5);
			}
		}
	}
}
