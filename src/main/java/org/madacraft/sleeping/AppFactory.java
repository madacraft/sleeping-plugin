package org.madacraft.sleeping;

import com.google.common.io.Closer;
import dagger.Component;
import org.madacraft.sleeping.app.App;

import javax.inject.Singleton;

@Singleton
@Component
public interface AppFactory {
    App app();

    static AppFactory create() {
        return DaggerAppFactory.create();
    }
}
