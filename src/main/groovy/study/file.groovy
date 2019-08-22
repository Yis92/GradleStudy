package study

import study.objectorention.Mybean
import study.objectorention.Person

def file = new File('../../../../build.gradle')

//读取每一行
//file.eachLine {
//    println(it)
//}

//def text = file.getText()
//println(text)

//def result = file.readLines()

//读取部分内容
//def reader = file.withReader {
//    //只读取100个字符
//    char[] buffer = new char[100]
//    it.read(buffer)
//    return buffer
//}
//println(reader)

//文件拷贝
//def copy(File sourceFile) {
//
//    def newFile = new File('liu.text')
//    if (!newFile.exists()) {
//        newFile.createNewFile()
//    }
//    try {
//        //开始写入拷贝1
////        newFile.withWriter {
////            it.append(sourceFile.getText())
////        }
//        //2
//        sourceFile.withReader {
//            def lines = it.readLines()
//            newFile.withWriter {
//                writer ->
//                    lines.each {
//                        writer.append(it + '\n')
//                    }
//            }
//        }
//        return true
//    } catch (IOException e) {
//        e.printStackTrace()
//    }
//}
//
//def isCreate = copy(file)
//println isCreate

//将对象写入到文件中，对象需要序列化
def myBean = new Mybean(name: 'liudayi', age: 18)

//将对象保存到文件中
def saveObject(Mybean myBean) {
    def newFile = new File('person.bin')
    if (!newFile.exists()) {
        newFile.createNewFile()
    }
    try {
        newFile.withObjectOutputStream {
            it.writeObject(myBean)
        }
        return true
    } catch (IOException e) {
        e.printStackTrace()
    }
    return false
}

def saveStatus= saveObject(myBean)
println(saveStatus)

//读取文件中的数据，解析成Object
def readObject() {
    def obj = null
    def newFile = new File('person.bin')
    if (!newFile.exists()) {
        newFile.createNewFile()
    }
    try {
        newFile.withObjectInputStream {
            obj = it.readObject()
        }
    } catch (Exception e) {
        e.printStackTrace()
    }
    return obj
}

def obj = readObject()
println obj
