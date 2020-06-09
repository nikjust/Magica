package net.mcreator.magica.procedures;

import net.minecraft.world.World;

import net.mcreator.magica.MagicaModVariables;
import net.mcreator.magica.MagicaModElements;

@MagicaModElements.ModElement.Tag
public class MagicaTabletItemInHandTickProcedure extends MagicaModElements.ModElement {
	public MagicaTabletItemInHandTickProcedure(MagicaModElements instance) {
		super(instance, 6);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MagicaTabletItemInHandTick!");
			return;
		}
		World world = (World) dependencies.get("world");
		MagicaModVariables.MapVariables.get(world).Overlay = (boolean) (true);
		MagicaModVariables.MapVariables.get(world).syncData(world);
	}
}
