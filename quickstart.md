
# 简介

Itweet-boot 英文含义推文，博客,我很早就以itweet.cn写博客，使用过hexo等很多优秀的静态博客系统，但是始终
找不到一款我自己合心意的博客系统，所以就诞生了itweet-boot项目。

`Itweet-boot`使用高效率Web开发框架spring boot开发，默认支持多主题，可以随便扩展新的主题，后台暂时不支持多主题，如果觉得项
目不错，请献出你的[Star](https://github.com/itweet/itweet-boot/stargazers)以示支持.

整个网站系统，使用非常简洁的设计元素，黑白灰三色构成，艺术感十足。

演示站点：http://www.itweet.cn

# 快速启动
你可以通过`git`命令克隆本项目源码到本地,通过`Intellij Idea`导入项目。
```
git clone git@github.com:itweet/itweet-boot.git
```

接下来，你可以通过`Intellij Idea`的`Import Project`导入项目，选择以`Maven`的方式导入。

进入项目后，需要完成以下操作：
   + `shift+command+o`快捷键，键入`application.properties`关键词，Enter进入,修改db配置为你的数据库连接。
   + `command+o`快捷键，键入`ItweetBootApplication`关键词，Enter进入，`shift+control+r`启动Itweet-boot应用。
   + 应用启动后，访问http://localhost:8080/admin/system/main，登录页面，输入默认超级管理员用户名密码：admin/123456

登录进入后台之后，完成以下操作：
   + 添加4篇以上博客类型的文章，并且处于`发布`状态
   + 添加4篇以上推文类型的文章，并且处于`发布`状态
   + 素材管理模块，上传类型为首页的4张以上`720*320`规格的照片
   + 访问http://localhost:8080 首页 即可正常使用。
  
到此，通过开发工具快速启动`Itweet-boot`项目完成，你可以正常开始开发新功能。

# 快速部署Itweet-boot项目
你可以通过`git`命令克隆本项目源码到本地
```
git clone git@github.com:itweet/itweet-boot.git
```

接下来，你可以进入项目
```
cd itweet-boot
```

执行`Maven`相关命令，构建部署包
```
mvn clean package -DskipTests
```

构建部署包成功之后，去项目的`target`目录下找`itweet-boot-0.0.1-SNAPSHOT.war`包，执行命令,
你可以把这个`war`包放到`tomcat`的`webapps`目录下，正常启动`tomcat`。

`Tomcat`启动后，访问http://your_itweet-boot_ip:8080/admin/system/main，登录后台管理平台，输入默认超级管理员用户名密码：admin/123456

登录进入后台之后，完成以下操作：
   + 添加4篇以上博客类型的文章，并且处于`发布`状态
   + 添加4篇以上推文类型的文章，并且处于`发布`状态
   + 素材管理模块，上传类型为首页的4张以上`720*320`规格的照片
   + 访问http://your_itweet-boot_ip:8080 首页 即可正常使用。
  
到此，快速部署Itweet-boot项目完成，您可以愉快的开始使用了。


# 特性

+ 大道至简,设计感十足
+ Markdown 文章发布
+ 支持多主题，方便扩展
+ 支持图片上传
+ 支持完整的权限管理
+ 支持文章管理
+ 支持教程管理
+ 支持素材管理
+ 支持标签管理
+ 支持类别管理
+ 功能模块化可插拔
+ 简洁高效扩展模块


原创文章，转载请注明： 转载自[Itweet](http://www.itweet.cn)的博客
`本博客的文章集合:` http://www.itweet.cn/blog/archive/
