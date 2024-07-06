package biggestxuan.emcworld.common.recipes;

/**
 *  EMC WORLD MOD
 *  @Author Biggest_Xuan
 *  2022/11/26
 */

import biggestxuan.emcworld.common.registry.EWRecipeTypes;
import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class ItemStageLimit implements IRecipe<RecipeWrapper> {
    private final ResourceLocation rl;
    private final Item item;
    private final String stage;

    public ItemStageLimit(ResourceLocation rl, Item item, String stage){
        this.rl = rl;
        this.item = item;
        this.stage = stage;
    }

    @Override
    public boolean matches(RecipeWrapper p_77569_1_, World p_77569_2_) {
        return true;
    }

    @Override
    public ItemStack assemble(RecipeWrapper p_77572_1_) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public ResourceLocation getId() {
        return rl;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return EWRecipeTypes.ITEM_STAGE_LIMIT.get();
    }

    @Override
    public IRecipeType<?> getType() {
        return ItemStageLimitType.INSTANCE;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.create();
    }

    public Item getItem() {
        return item;
    }

    public String getStage() {
        return stage;
    }

    public static class ItemStageLimitType implements IRecipeType<ItemStageLimit>{
        public static final IRecipeType<ItemStageLimit> INSTANCE = EWRecipeTypes.register("item_stage_limit");
    }

    public static class ItemStageLimitSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ItemStageLimit> {
        public static IRecipeSerializer<ItemStageLimit> serializer = new ItemStageLimitSerializer();

        @Override
        public ItemStageLimit fromJson(ResourceLocation p_199425_1_, JsonObject p_199425_2_) {
            Item item = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(p_199425_2_,"item")).getItem();
            String stage = JSONUtils.getAsString(p_199425_2_,"stage");
            return new ItemStageLimit(p_199425_1_,item,stage);
        }

        @Nullable
        @Override
        public ItemStageLimit fromNetwork(ResourceLocation p_199426_1_, PacketBuffer p_199426_2_) {
            Item item = p_199426_2_.readItem().getItem();
            String stage = p_199426_2_.readUtf();
            return new ItemStageLimit(p_199426_1_,item,stage);
        }

        @Override
        public void toNetwork(PacketBuffer p_199427_1_, ItemStageLimit p_199427_2_) {
            ItemStack stack = new ItemStack(p_199427_2_.item,1);
            String stage = p_199427_2_.stage;
            p_199427_1_.writeItem(stack);
            p_199427_1_.writeUtf(stage);
        }
    }
}
