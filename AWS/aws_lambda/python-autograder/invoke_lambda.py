import boto3
import json
import pymysql


ASSIGNMENT_ID = 1

db = pymysql.connect(host='localhost', user='root', password='*', db='ruby', charset='utf8')
curs = db.cursor()

#Select Query
sql = """select submit_code from ruby.submissions order by submit_date desc limit 1"""
curs.execute(sql)
select = list(curs.fetchall())
db.commit()
data_string = select[0][0]

# python을 json으로 convert
# read_file = open("arithmetic_function_test.py","r").read()
json_file = json.dumps({"body":data_string}, default=str)
test = json_file.encode("utf-8")

# Lambda 호출
lambda_client = boto3.client('lambda')
response = lambda_client.invoke(FunctionName='Lambda-Test', 
                     InvocationType='Event',
                     Payload=test)
print(response['Payload'].read())

