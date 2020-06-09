package net.mcreator.magica.procedures;

import net.minecraft.world.World;

import net.mcreator.magica.MagicaModVariables;
import net.mcreator.magica.MagicaModElements;

@MagicaModElements.ModElement.Tag
public class MagicaTabletRightClickedInAirProcedure extends MagicaModElements.ModElement {
	public MagicaTabletRightClickedInAirProcedure(MagicaModElements instance) {
		super(instance, 8);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MagicaTabletRightClickedInAir!");
			return;
		}
		World world = (World) dependencies.get("world");
		if (((false) == (MagicaModVariables.MapVariables.get(world).Overlay))) {
			MagicaModVariables.MapVariables.get(world).Overlay = (boolean) (true);
			MagicaModVariables.MapVariables.get(world).syncData(world);
		} else {
			MagicaModVariables.MapVariables.get(world).Overlay = (boolean) (false);
			MagicaModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
