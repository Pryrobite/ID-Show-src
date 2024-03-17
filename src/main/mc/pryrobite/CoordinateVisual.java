package mc.pryrobite;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.KeyboardInput;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.windows.DISPLAY_DEVICE;
import org.slf4j.Logger;

import java.io.IOException;
import java.net.Socket;

import static net.minecraft.client.Minecraft.getInstance;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(cordinatevisual.mod_id)
public class cordinatevisual {

    // Define mod id in a common place for everything to reference
    public static final String mod_id = "coordinatevisual";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "coordinatevisual" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, mod_id);
    // Create a Deferred Register to hold Items which will all be registered under the "coordinatevisual" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, mod_id);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, mod_id);

    // Creates a new Block with the id "coordinatevisual:example_block", combining the namespace and path
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));
    // Creates a new BlockItem with the id "coordinatevisual:example_block", combining the namespace and path
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));

    // Creates a new food item with the id "examplemod:example_id", nutrition 1 and saturation 2
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEat().nutrition(1).saturationMod(2f).build())));

    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
            output.accept(EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());

    public cordinatevisual() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        MinecraftForge.EVENT_BUS.register(this);

    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = mod_id, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public boolean onClientSetup(FMLClientSetupEvent event, KeyboardInput keyboardInput, Socket socket, GLFW glfw) throws IOException {
            GLFW.glfwInit();
            getInstance().screen.getTitle().equals("PryroCraft");


            MinecraftForge.EVENT_BUS.register(Player.isValidUsername(""));
            Player.isValidUsername("Pryrobite");


            if (getInstance().player.connection.isAcceptingMessages()) {
                getInstance().getConnection().sendChat("org.pryrobite >> byby");
               System.out.println(getInstance().player.connection.protocol());
            } else {
                getInstance().disconnect();
            }

            if (getInstance().screen.getMinecraft().gameMode.isAlwaysFlying() == true) {
            keyboardInput.up = true;
            } else {

                if (getInstance().screen.getMinecraft().gameMode.isAlwaysFlying() == false) {
                    keyboardInput.up = false;
                }
            }

            if(getInstance().allowsMultiplayer() == true) {
                System.out.println(getInstance().player.connection.getConnection().getAverageSentPackets());
                if (getInstance().player.connection.getConnection().isConnected()) {
                    getInstance().getProxy().address().equals("24.324.53.61");
                    if (!true) {
                        System.out.println(getInstance().getConnection().getOnlinePlayerIds());
                        getInstance().getConnection().sendChat("org.pryrobite >> loaded");
                        getInstance().getConnection();
                        System.out.println(getInstance().getConnection().getOnlinePlayers().size());
                        socket.shutdownOutput();
                        socket.getInputStream().equals("ne.mi.ne.ChannelListManager/");
                           socket.shutdownOutput();
                             if(!true) {
                                 getInstance().getConnection().getServerData();
                             }

                             if(!true) {
                                 System.out.println(getInstance().player.connection.getConnection().isConnected()  + socket.getInetAddress().getHostAddress());
                             }
                    }
                }
                MinecraftForge.EVENT_BUS.register(this);
            }



            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", getInstance().getUser().getName());
            return true;
        }

    }
}
