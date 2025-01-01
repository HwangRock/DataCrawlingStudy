import requests
from bs4 import BeautifulSoup

url = "http://127.0.0.1:5500/week1_WebcrawlingandRegex/problem/problem2.html"
response = requests.get(url) # url에서 HTML 파일을 가져옴.

soup=BeautifulSoup(response.text, 'html.parser') # BeautifulSoup을 사용해서 HTML 파일에서 파싱해서 DOM 트리 형성

header=soup.find("h1").text # <h1> 태그를 찾아내서 해당 태그의 내용을 가져옴.
id=soup.find("p", id="description").text  # <p> 태그의 id가 description인 속성을 변수에 저장
saveAll=list(soup.find_all("p", class_="info")) # <p> 태그의 class=info의 속성을 모두 리스트에 저장

print(header)
print(id)
for s in saveAll:
    print(s.text)