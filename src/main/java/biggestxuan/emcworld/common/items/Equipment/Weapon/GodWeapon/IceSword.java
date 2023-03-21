package biggestxuan.emcworld.common.items.Equipment.Weapon.GodWeapon;

/**
 *  EMC WORLD MOD
 *  @Author Biggest_Xuan
 *  2022/09/28
 */

import biggestxuan.emcworld.api.item.equipment.weapon.BaseEMCGodSword;
import biggestxuan.emcworld.common.utils.MathUtils;
import net.minecraft.item.ItemStack;

public class IceSword extends BaseEMCGodSword {
    public IceSword() {
        super(8f,0x244bb9);
    }

    @Override
    public float getBaseDamage(ItemStack stack) {
        float base = (float) ((Math.pow(1.155f,Math.min(22,getLevel(stack)))*baseDamage)-baseDamage);
        return getLevel(stack) >= 22 ? (float) MathUtils.getGodWeaponAddition(stack, base) : base;
    }

    @Override
    public int getEnchantmentValue() {
        return 20;
    }

    @Override
    public double getBaseEMCWhenAttack(ItemStack stack) {
        int level = this.getLevel(stack);
        return Math.pow(0.97f,level);
    }

    @Override
    public double getBaseCriticalChance(ItemStack stack) {
        return Math.pow(1.014,getLevel(stack)) - 1;
    }

    @Override
    public double getBaseCriticalRate(ItemStack stack) {
        return Math.pow(1.019,getLevel(stack));
    }

    @Override
    public long getBaseModifySecond(ItemStack stack) {
        int level = this.getLevel(stack);
        if(level <= 5) return 0;
        return Math.round(Math.pow(1.3,level-5)*8);
    }

    @Override
    public double getBaseRange(ItemStack stack){
        int level = getLevel(stack);
        if(level <= 11) return 0d;
        if(level <= 15) return (level-10) * 0.25d;
        if(level <= 18) return (level-15) * 0.3d + 1.0d;
        if(level <= 20) return (level-18) * 0.35d + 1.6d;
        if(level <= 23) return (level-20) * 0.4d + 2.8d;
        else return 4.0d + 0.5d;
    }
}
