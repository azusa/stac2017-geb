import geb.spock.GebReportingSpec
import geb.spock.GebSpec

class GebishOrgSpec extends GebReportingSpec {

    def "Book of Gebの最新バージョンが表示できる"() {
        when: "Gebのホームページを表示する"
        to GebishOrgHomePage

        and: "マニュアルのメニューを開く"
        manualsMenu.open()

        then: "currentのリンクがcurrentではじまっている"
        manualsMenu.links[0].text().startsWith("current")

        when: "リンクをクリックする"
        manualsMenu.links[0].click()

        then: "The Book Of Gebのページが表示される"
        at TheBookOfGebPage

    }
}