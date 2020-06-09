package net.mcreator.magica.procedures;

import net.minecraft.world.World;

import net.mcreator.magica.MagicaModVariables;
import net.mcreator.magica.MagicaModElements;

@MagicaModElements.ModElement.Tag
public class MagicaTabletOnPlayerStoppedUsingProcedure extends MagicaModElements.ModElement {
	public MagicaTabletOnPlayerStoppedUsingProcedure(MagicaModElements instance) {
		super(instance, 7);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MagicaTabletOnPlayerStoppedUsing!");
			return;
		}
		World world = (World) dependencies.get("world");
		MagicaModVariables.MapVariables.get(world).Overlay = (boolean) (false);
		MagicaModVariables.MapVariables.get(world).syncData(world);
	}
}
