package criteriatest

enum TestEnum {
  TEST_ONE('Test one'),
  TEST_TWO('Test Two')

  String type

  TestEnum(String type) {
    this.type = type
  }

  static list() {
    [TEST_ONE, TEST_TWO]
  }

  String toString() {
    return type
  }
    static constraints = {
    }
}
