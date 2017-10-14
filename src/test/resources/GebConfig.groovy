/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/

import org.apache.commons.lang3.SystemUtils
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
		driver = { new ChromeDriver() }
		setUpChromeDriver(BUILD_DIR)
		break
	case "firefox" :
		atCheckWaiting = 1
		def geckodriverFilename = SystemUtils.IS_OS_WINDOWS ? "geckodriver.exe" : "geckodriver"
		System.setProperty "webdriver.gecko.driver", "$BUILD_DIR/webdriver/geckodriver/$geckodriverFilename"
		driver = { new FirefoxDriver() }
		break
	case "chromeHeadless" :
		setUpChromeDriver(BUILD_DIR)
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

private void setUpChromeDriver(String buildDir) {
	def chromedriverFilename = SystemUtils.IS_OS_WINDOWS ? "chromedriver.exe" : "chromedriver"
	System.setProperty "webdriver.chrome.driver", "$buildDir/webdriver/chromedriver/$chromedriverFilename"
}

baseUrl = "http://gebish.org"

