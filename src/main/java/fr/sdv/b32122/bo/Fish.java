package fr.sdv.b32122.bo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity
public class Fish extends Animal {
    @Enumerated( EnumType.STRING )
    private FishLivEnv livingEnv;

    public Fish() {
    }

    public Fish(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    public Fish(Date birth, String couleur, FishLivEnv livingEnv) {
        super(birth, couleur);
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv( FishLivEnv livingEnv ) {
        this.livingEnv = livingEnv;
    }
}
