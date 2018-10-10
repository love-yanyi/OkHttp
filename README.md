# OkHttp
## OkHttp请求封装
### 使用方法

#### 方法一(老版,已停止维护)
module 下添加

     compile 'com.github.BenYanYi:OkHttp:1.1.6'

<br/>
project 下添加

    allprojects {
        repositories {
            jcenter()
            maven {
                url 'https://jitpack.io'
            }
        }
    }

<br/>

#### 方法二(最新)
module 下添加

    compile 'com.yanyi.benyanyi:okhttplib:1.1.0'
    
### 更新记录
* 2018/10/10(1.1.0) 添加写入超时限定
* 2018/09/28(1.0.9) 添加自定义Request方法
* 2018/09/14(1.0.8) 优化下载文件方法
* 2018/09/12(1.0.7) 修复下载文件回调没返回问题,下载路径都是根目录下
