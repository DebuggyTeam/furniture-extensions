package gay.debuggy.furniture_extensions;

import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FurnitureExtensions implements ModInitializer { 
	public static final Logger LOGGER = LoggerFactory.getLogger("Furniture Extensions");

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());
		
	}
	
	public static Identifier id(String path) {
		return new Identifier("fur_ex", path);
	}
}
