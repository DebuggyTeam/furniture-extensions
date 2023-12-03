package gay.debuggy.furniture_extensions;

import gay.debuggy.furniture_extensions.blocks.DeckChair;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FurnitureExtensions implements ModInitializer { 
	public static final Logger LOGGER = LoggerFactory.getLogger("Furniture Extensions");
	public static final DeckChair OAK_DECK_CHAIR = new DeckChair(QuiltBlockSettings.copyOf(Blocks.OAK_PLANKS));

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());
		
		
		Registry.register(Registries.BLOCK, id("oak_deck_chair"), OAK_DECK_CHAIR);
		Registry.register(Registries.ITEM, id("oak_deck_chair"), new BlockItem(OAK_DECK_CHAIR, new QuiltItemSettings()));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.addItem(OAK_DECK_CHAIR));
	}
	
	public static Identifier id(String path) {
		return new Identifier("furniture_extensions", path);
	}
}
