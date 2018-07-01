import Controllers.ServletListener;
import Services.Modules.HigherServiceModule;
import com.google.inject.Guice;

public class Testing {
    public static void main(String[] args) throws Throwable {
        ServletListener.injector = Guice.createInjector(new HigherServiceModule());
        TestRunner testRunner = new TestRunner();
        testRunner.AssertAll();
    }
}
