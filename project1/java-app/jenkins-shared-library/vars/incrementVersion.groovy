def call() {
    sh './gradlew incrementVersion --versionIncrementType=MINOR > /dev/null'
    def APP_VERSION = sh (
        script: "./gradlew printVersion -Psnapshot=false |  awk '/^Version:/ { gsub(/^Version: /, \"\", \$0); print \$0 }'",
        returnStdout: true
    ).trim()
    env.IMAGE_VERSION = "$APP_VERSION-$BUILD_NUMBER"
    echo "Resolved image version: ${env.IMAGE_VERSION}"
}
