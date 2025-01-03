import requests
from bs4 import BeautifulSoup

url = "http://127.0.0.1:5500/week1_WebcrawlingandRegex/problem/problem3.html"
response = requests.get(url) # url에서 HTML 파일을 가져옴.

soup=BeautifulSoup(response.text, 'html.parser') # BeautifulSoup을 사용해서 HTML 파일에서 파싱해서 DOM 트리 형성


# 1번째 풀이. \n을 split한 하드코딩 방식. 유지보수의 측면에서 비효율적.
'''
header=soup.findChildren("tr")# <tr> 태그의 자식들을 리스트로 저장

table=[]
for i in header:
    table.append(i.text)

product=[]
price=[]

for i in table:
    h=i.split("\n")
    product.append(h[1])
    price.append(h[2])

print("product data is ", product)
print("price data is ", price)
'''

# 2번째 풀이. <tr>의 루프를 돌면서 td를 추출해내고, 데이터도 구조화시켜서 유지보수의 측면을 높임.
rows = soup.find_all("tr")
table_data = []
for row in rows[1:]:
    columns = row.find_all("td")
    table_data.append({
        "product": columns[0].text.strip(),
        "price": columns[1].text.strip()
    })
print(table_data)

