
# 贡献
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
  
到此，通过开发工具快速启动`Itweet-boot`项目完成，你可以正常开始新功能开发。

# Issues
如果你有任何使用问题，可以通过[Issues](https://github.com/itweet/itweet-boot/issues)反馈Itweet-boot，我们会尽快修复问题。


# 版权
 - 原创文章，转载请注明： 转载自[Itweet](http://www.itweet.cn)的博客
 - `本博客的文章集合:` http://www.itweet.cn/blog/archive/
