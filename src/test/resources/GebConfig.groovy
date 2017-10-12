/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.chrome.ChromeOptions

waiting {
	timeout = 5
}

environments {

	gebishorg {
		baseUrl = "http://gebish.org"
	}

}

switch (System.getProperty("browser")) {

	case "chrome" :
		driver = { new ChromeDriver() }
		break
	case "firefox" :
		atCheckWaiting = 1
		driver = { new FirefoxDriver() }
		break
	case "chromeHeadless" :
		driver = {
			ChromeOptions o = new ChromeOptions()
			o.addArguments('headless')
			new ChromeDriver(o)
		}
		break
	case "edge" :
		driver = { new EdgeDriver()}
		break
	case "ie" :
		driver = { new InternetExplorerDriver() }
		break
	default :
		throw new IllegalStateException()

}
baseUrl = "http://gebish.org"


