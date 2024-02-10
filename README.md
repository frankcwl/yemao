# Yemao
> 基于 [Mirai Console](https://github.com/mamoe/mirai-console) 的碧蓝档案（日服）角色评价插件

该插件使用[bilibili夜猫咪喵喵猫](https://space.bilibili.com/425535005)角色评价专栏中的图片，并根据图片描述自动为图片指定文件名。

## 用法
发送`.<角色名/角色昵称/角色文件名>`获取角色评价图片，例如`.伊织`、`.佐仓`和`.Iori`都能获取到伊织的角色评价。

<del>其中角色文件名是插件自动生成的，格式为`角色名字罗马音_皮肤英文名`，例如`梓(泳装)`的文件名为`Azusa_Swimsuit`，`睦月(正月)`的文件名为`Mutsuki_NewYear`，皮肤英文名详见插件data文件夹中的pathname.yml。</del>
由于夜猫佬已经将专栏中的角色名字后添加了皮肤名，本插件只对特殊名字进行重命名，详见插件data文件夹中的pathname.yml中的redirect_map。

角色名和角色昵称是插件第一次启动时和检索到新角色时由bot管理员手动设置的，详见插件data文件夹中的nickname.yml，具体设置方法见指令部分。可使用主目录下的yaml文件，该文件将不定时更新。

bot启动后插件将每24小时检索一次bilibili专栏，若检索到新角色，将提示管理员为新角色添加昵称。<del>若检索到新皮肤系列，将提示管理员为新皮肤系列添加名称。</del>

## 指令
| 指令                                    | 描述           |
|:----------------------------------------|:---------------|
| `/yemao nickname <pathname> <nicknames>`| 为角色添加昵称 |
| <del>`/yemao costume <costumename> <pathname>`</del>| <del>为皮肤添加名称</del> |
| `/yemao download                       `| 重新下载所有图片 |
