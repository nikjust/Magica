package net.mcreator.magica.procedures;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.magica.entity.JeffPhase2Entity;
import net.mcreator.magica.entity.JeffArmEntity;
import net.mcreator.magica.MagicaModElements;

@MagicaModElements.ModElement.Tag
public class JeffEntityDiesProcedure extends MagicaModElements.ModElement {
	public JeffEntityDiesProcedure(MagicaModElements instance) {
		super(instance, 48);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure JeffEntityDies!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure JeffEntityDies!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure JeffEntityDies!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure JeffEntityDies!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			Entity entityToSpawn = new JeffPhase2Entity.CustomEntity(JeffPhase2Entity.entity, world);
			entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0);
			world.addEntity(entityToSpawn);
		}
		if (!world.isRemote) {
			Entity entityToSpawn = new JeffArmEntity.CustomEntity(JeffArmEntity.entity, world);
			entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0);
			world.addEntity(entityToSpawn);
		}
	}
}
