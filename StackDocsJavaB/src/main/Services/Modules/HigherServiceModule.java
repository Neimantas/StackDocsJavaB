package Services.Modules;

import Services.ICrud;
import Services.IDataBase;
import Services.IHigherService;
import Services.Impl.Crud;
import Services.Impl.DataBase;
import Services.Impl.HigherService;
import com.google.inject.AbstractModule;

public class HigherServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IDataBase.class).to(DataBase.class);
        bind(ICrud.class).to(Crud.class);
        bind(IHigherService.class).to(HigherService.class);
    }
}
