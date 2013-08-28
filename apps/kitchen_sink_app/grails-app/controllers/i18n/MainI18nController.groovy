package i18n

class MainI18nController {
    def index = {}

    def formatNumbers(MyCommandObject mco) {
        [commandObject: mco]
    }
}

class MyCommandObject {
    Float someFloat
    float somePrimitiveFloat
    Double someDouble
    Long someLong
    BigDecimal someBigDecimal
    BigInteger someBigInteger
}
