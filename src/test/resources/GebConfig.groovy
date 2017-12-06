/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/


import io.github.bonigarcia.wdm.ChromeDriverManager
import io.github.bonigarcia.wdm.EdgeDriverManager
import io.github.bonigarcia.wdm.FirefoxDriverManager
import io.github.bonigarcia.wdm.InternetExplorerDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver

def targetBrowser = System.getProperty("browser") == null ? "chrome" :  System.getProperty("browser")
def BUILD_DIR = System.getProperty("buildDir") == null ? "build" :  System.getProperty("buildDir")

System.setProperty "geb.build.reportsDir", "$BUILD_DIR/reports/${targetBrowser}/geb"

waiting {
	timeout = 5
}

environments {

	gebishorg {
		baseUrl = "http://gebish.org"
	}
	heroku {
		baseUrl = "http://gebish.herokuapp.com"
	}

}

switch (targetBrowser) {

	case "chrome" :
		ChromeDriverManager.getInstance().setup()
		driver = { new ChromeDriver() }
		break
	case "firefox" :
		atCheckWaiting = 1
		FirefoxDriverManager.getInstance().setup();
		driver = { new FirefoxDriver() }
		break
	case "chromeHeadless" :
		ChromeDriverManager.getInstance().setup()
		driver = {
			ChromeOptions o = new ChromeOptions()
			o.addArguments('headless')
			new ChromeDriver(o)
		}
		break
	case "edge" :
		EdgeDriverManager.getInstance().setup()
		driver = { new EdgeDriver()}
		break
	case "ie" :
		InternetExplorerDriverManager.getInstance().setup()
		driver = { new InternetExplorerDriver() }
		break
	default :
		throw new IllegalStateException()

}


baseUrl = "http://gebish.org"

