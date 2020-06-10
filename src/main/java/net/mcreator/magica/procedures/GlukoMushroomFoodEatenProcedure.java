package net.mcreator.magica.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;

import net.mcreator.magica.entity.JeffEntity;
import net.mcreator.magica.MagicaModVariables;
import net.mcreator.magica.MagicaModElements;

@MagicaModElements.ModElement.Tag
public class GlukoMushroomFoodEatenProcedure extends MagicaModElements.ModElement {
	public GlukoMushroomFoodEatenProcedure(MagicaModElements instance) {
		super(instance, 51);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure GlukoMushroomFoodEaten!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure GlukoMushroomFoodEaten!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure GlukoMushroomFoodEaten!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure GlukoMushroomFoodEaten!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((0 == (MagicaModVariables.MapVariables.get(world).jumbo))) {
			if (!world.isRemote) {
				Entity entityToSpawn = new JeffEntity.CustomEntity(JeffEntity.entity, world);
				entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0);
				world.addEntity(entityToSpawn);
			}
		} else {
			MagicaModVariables.MapVariables.get(world).jumbo = (double) ((MagicaModVariables.MapVariables.get(world).jumbo) - 1);
			MagicaModVariables.MapVariables.get(world).syncData(world);
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent((("Boss spawns in ") + ""
							+ ((new java.text.DecimalFormat("#").format((MagicaModVariables.MapVariables.get(world).jumbo)))) + "" + (" seconds"))));
			}
		}
	}
}
