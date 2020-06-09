package net.mcreator.magica.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

import net.mcreator.magica.block.MagicQuartzOreBlock;
import net.mcreator.magica.MagicaModElements;

@MagicaModElements.ModElement.Tag
public class DirtyMagicQuartzOreOnBlockRightClickedProcedure extends MagicaModElements.ModElement {
	public DirtyMagicQuartzOreOnBlockRightClickedProcedure(MagicaModElements instance) {
		super(instance, 23);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure DirtyMagicQuartzOreOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure DirtyMagicQuartzOreOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure DirtyMagicQuartzOreOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DirtyMagicQuartzOreOnBlockRightClicked!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((Math.random() < 0.1)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), MagicQuartzOreBlock.block.getDefaultState(), 3);
		}
	}
}
