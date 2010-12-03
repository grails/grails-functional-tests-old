package criteriatest

enum TestEnumTwo {

  TEST_THREE('Test Three'),
  TEST_FOUR('Test Four')

  String type

  TestEnumTwo(String type) {
    this.type = type
  }

  static list() {
    [TEST_THREE, TEST_FOUR]
  }

  String toString() {
    return type
  }
    static constraints = {
    }
}
