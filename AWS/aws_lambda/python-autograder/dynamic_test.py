import imp

code_str = """
def addition(a, b):
    # '''
    # Input:
    #   -a: 실수 값 (Integer of float)
    #   -b: 실수 값 (Integer of float)
    # Output:
    #   -두 값의 합
    # Examples:
    #   >>> addition(3,5)
    #   8
    #   >>> addition(3,2)
    #   5
    # '''
    # pass
    # ===Modify codes below=============

    result = None

    # ==================================

    return result

def minus(a, b):
    # '''
    # Input:
    #   -a: 실수 값 (Integer of float)
    #   -b: 실수 값 (Integer of float)
    # Output:
    #   -두 값의 차
    # Examples:
    #   >>> minus(3,5)
    #   -2
    #   >>> minus(3,2)
    #   1
    # '''
    # pass
    # ===Modify codes below=============

    result = None

    # ==================================

    return result


def multiplication(a, b):
    # '''
    # Input:
    #   -a: 실수 값 (Integer of float)
    #   -b: 실수 값 (Integer of float)
    # Output:
    #   -두 값의 곱
    # Examples:
    #   >>> multiplication(3,5.1)
    #   15.3
    #   >>> multiplication(3,2)
    #   6
    # '''
    # pass
    # ===Modify codes below=============

    result = None

    # ==================================

    return result


def division(a, b):
    # '''
    # Input:
    #   -a: 실수 값 (Integer of float)
    #   -b: 실수 값 (Integer of float)
    # Output:
    #   -a를 b로 나눈 값
    # Examples:
    #   >>> division(5,5)
    #   1
    #   >>> division(4,2)
    #   2
    # '''
    # pass
    # ===Modify codes below=============

    result = None

    # ==================================

    return result


def main():
    print ("Addition Test")
    print (addition(3,5)) # Expected Result: 8
    print (addition(10,5) == 15) # Expected Result: True
    print ("Addition Test Closed")

    print ("Minus Test")
    print (minus(3,5)) # Expected Result: -2
    print (minus(10,5) == 5) # Expected Result: True
    print (minus(10,15) == 5) # Expected Result: False
    print ("Addition Test Closed ")

    print ("Multiplication Test")
    print (multiplication(3,5)) # Expected Result: 15
    print (multiplication(10,5) == 50) # Expected Result: True
    print (multiplication(10,-3) == 20) # Expected Result: False
    print ("Addition Test Closed ")

    print ("division Test")
    print (division(5,5)) # Expected Result: 1
    print (division(5,4)) # Expected Result: 1.25
    print (division(10,5) == 2) # Expected Result: True
    print (division(10,-3) == 0.33333) # Expected Result: False
    print ("division Test Closed ")


if __name__ == "__main__":
    main()
""".strip()

test = {
    "statusCode": 200,
    "headers": {"Access-Control-Allow-Origin": "*"},
    "body": "import unittest\\n\\nimport arithmetic_function\\n\\n\\nclass TestArithmeticFunction(unittest.TestCase):\\n    def test_addition(self):\\n        self.assertEqual(8, arithmetic_function.addition(3, 5))\\n        self.assertEqual(65, arithmetic_function.addition(60, 5))\\n        self.assertEqual(43, arithmetic_function.addition(20, 23))\\n        self.assertEqual(-23, arithmetic_function.addition(0, -23))\\n\\n    def test_minus(self):\\n        self.assertEqual(-2, arithmetic_function.minus(3, 5))\\n        self.assertEqual(55, arithmetic_function.minus(60, 5))\\n        self.assertEqual(-3, arithmetic_function.minus(20, 23))\\n        self.assertEqual(23, arithmetic_function.minus(0, -23))\\n\\n    def test_multiplication(self):\\n        self.assertEqual(50, arithmetic_function.multiplication(10, 5))\\n        self.assertEqual(0, arithmetic_function.multiplication(0, -23))\\n        self.assertEqual(144, arithmetic_function.multiplication(12, 12))\\n\\n    def test_division(self):\\n        self.assertEqual(float(2), arithmetic_function.division(10, 5))\\n        self.assertEqual(10/6.0, arithmetic_function.division(10, 6))\\n        self.assertEqual(12/float(12), arithmetic_function.division(12, 12))",
}

test_code = test["body"].replace("\\n", "\n")

import sys, imp
import unittest

mymodule = imp.new_module("arithmetic_function")
exec(code_str, mymodule.__dict__)

mod_name = "test_arithmetic_function"
test_module = imp.new_module(mod_name)
exec(test_code, test_module.__dict__)

for name in dir(test_module):
    obj = getattr(test_module, name)
    try:
        if issubclass(obj, unittest.TestCase):
            unittest_class = obj
            break
    except TypeError:  # If 'obj' is not a class
        pass
if hasattr(test_module, unittest_class.__name__):
    class_inst = getattr(test_module, unittest_class.__name__)

function_list = [
    function for function in dir(unittest_class) if function.startswith("test_")
]

test_result = {funtion_name: "S" for funtion_name in function_list}

suite = unittest.TestLoader().loadTestsFromTestCase(class_inst)
results = unittest.TextTestRunner(verbosity=2).run(suite)

test_failuers = []
test_erros = []

for i in range(len(results.failures)):
    fail_function_name = results.failures[i][0].__dict__["_testMethodName"]
    test_result[fail_function_name] = "F"
for i in range(len(results.errors)):
    error_function_name = results.errors[i][0].__dict__["_testMethodName"]
    test_result[error_function_name] = "E"
print(test_result)
