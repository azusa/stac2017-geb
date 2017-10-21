[技術書典3](https://techbookfest.org/event/tbf03)で頒布した[すいーとみゅーじっく vol.4](http://pub.fieldnotes.jp/entry/sweetmusic-vol4) のサンプルコードです。

[geb/geb-example-gradle](https://github.com/geb/geb-example-gradle)からフォークしたものです。

## Usage

ブラウザーごとのテスト実行方法は以下の通りです。デフォルトはChromeです。

    ./gradlew test -Pbrowser=chrome
    ./gradlew test -Pbrowser=chromeHeadless
    ./gradlew test -Pbrowser=firefox
    ./gradlew test -Pbrowser=ie
    ./gradlew test -Pbrowser=edge

テストの実行時にシステムプロパティー`geb.env`を切り替える場合は、以下の通り実行します。

    gradlew test -Ptarget=heroku

