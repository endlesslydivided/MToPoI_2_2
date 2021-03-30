package planets;

import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class PlanetsTest {

    Planets planets1 = new Planets("Pluto",1000,150,true,true);;

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite запустится до запуска всех тестов");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite запустится после запуска всех тестов");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Аннотированный метод будет запущен только один раз, прежде чем будет вызван первый тестовый метод в текущем классе.");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Аннотированный метод будет запущен только один раз после запуска всех тестовых методов в текущем классе.");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Аннотированный метод будет запущен только один раз после запуска всех тестовых методов в текущем классе.");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Аннотированный метод будет запущен после запуска всех тестовых методов, принадлежащих классам внутри тега <test>");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Аннотированный метод будет запускаться перед каждым тестовым методом.");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Аннотированный метод будет запускаться после каждого метода тестирования.");
    }

    @Test(timeOut = 100,groups = { "functest", "checkintest" })
    public void testGetName() {
        // act
        var res = planets1.getName();

        // assert
        Assert.assertEquals("Pluto", res);
    }

    @Test
    public void testGetRadius() {
        // act
        var res = planets1.getRadius();

        // assert
        Assert.assertEquals(1000, res);
    }

    @Test(timeOut = 100 ,groups = { "functest"},dependsOnMethods  = {"initEnvironmentTest"} )
    public void testGetAvgTemperature() {
        // act
        var res = planets1.getAvgTemperature();

        // assert
        Assert.assertEquals(150, res);
    }

    @Test(timeOut = 100 ,groups = { "functest", "checkintest" })
    public void testIsHaveAtmosphere() {
        // act
        var res = planets1.isHaveAtmosphere();

        // assert
        Assert.assertEquals(true, res);
    }

    @Test(timeOut = 100 ,groups = { "functest", "checkintest" })
    public void testIsHaveLife( ) {
        // act
        var res = planets1.isHaveAtmosphere();

        // assert
        Assert.assertEquals(true, res);
    }

    @Test(timeOut = 100 ,groups = { "functest" },dataProvider = "test1")
    public void testSetName(String myName) {
        planets1.setName(myName);
        Assert.assertEquals(planets1.Name,myName);
    }

    @DataProvider(name = "test1")
    public static Object[] primeNumbers() {
        return new  Object[]{"Pluto","Mars"};
    }

    @Test(timeOut = 100,groups = { "functest" })
    @Parameters ( "myRadius")
    public void testSetRadius(int myRadius) {
        planets1.setRadius(myRadius);
        Assert.assertEquals(planets1.Radius,myRadius);
    }

    @Test(timeOut = 100,groups = { "functest" } )
    public void testSetAvgTemperature() {
    }

    @Test(timeOut = 100,groups = { "functest" } )
    public void testSetHaveAtmosphere() {
    }

    @Test(timeOut = 100,groups = { "functest" } )
    public void testSetHaveLife() {
    }

    @Test(groups = { "functest" } )
    public void initEnvironmentTest() {
        System.out.println("This is initEnvironmentTest");
    }
}