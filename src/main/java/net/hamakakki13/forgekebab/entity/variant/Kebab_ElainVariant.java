package net.hamakakki13.forgekebab.entity.variant;
import java.util.Arrays;
import java.util.Comparator;


public enum Kebab_ElainVariant {
    DEFAULT(0),
    VAUVA(1);

    private static final Kebab_ElainVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(Kebab_ElainVariant::getId)).toArray(Kebab_ElainVariant[]::new);
    private final int id;

    Kebab_ElainVariant(int p_30984_) {
        this.id = p_30984_;
    }

    public int getId() {
        return this.id;
    }

    public static Kebab_ElainVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
