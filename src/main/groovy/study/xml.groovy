package study

import groovy.xml.MarkupBuilder

String strXml = '''
<response version-api="2.0">
<dev>
    <book id= "liu">
        文本
    </book>
</dev>
</response>
'''

//开始解析xml数据
def xmlData = new XmlSlurper()
def response = xmlData.parseText(strXml)
println(response.dev.book.text())
println(response.dev.book.@id)

//生成xml格式数据
def sw = new StringWriter()
def xmlBuilder =new MarkupBuilder(sw)
//根结点langs创建成功
xmlBuilder.langs(type:'current',count:'3',mainstream:'true'){
    language(flavor :'static',version:'1.5','java')
    language(flavor :'dynamic',version:'1.6','groovy')
    language(flavor :'dynamic',version:'1.9','JavaScript')
}

println(sw)



