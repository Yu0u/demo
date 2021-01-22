# 寒假作业1

### 实现功能

- **注册**

  实现了在注册时密码加密。

- **登录**  

  整合了shiro框架进行持久化登录

- **注销** 

  通过shiro的Security.logout方法实现注销

## 注册

### 基本信息

- **接口URL：** `http://81.68.155.14:8080/user/register`
- **请求方式：** `POST`
- **Content-Type：** `multipart/form-data`

### 请求参数

接口请求参数见下表：

接口请求参数见下表：

#### Body参数说明 (multipart/form-data)

| **参数名** | **示例值** | **是否必填** | **参数描述**           |
| :--------- | :--------- | :----------- | :--------------------- |
| username   | admin11111 | 必填         | `用户名且长度为6-12位` |
| password   | 12345678   | 必填         | `密码`                 |

### 响应示例

#### 正确响应示例

```json
{
	"success": true,
	"code": 200,
	"message": "注册成功",
	"data": null
}
```

#### 错误响应示例

```json
{
	"success": false,
	"code": 1002,
	"message": "用户已存在",
	"data": null
}
```

## 登录

### 基本信息

- **接口URL：** `http://81.68.155.14:8080/user/login`
- **请求方式：** `POST`
- **Content-Type：** `application/x-www-form-urlencoded`

### 请求参数

接口请求参数见下表：

#### Body参数说明 (application/x-www-form-urlencoded)

| **参数名** | **示例值** | **是否必填** | **参数描述**           |
| :--------- | :--------- | :----------- | :--------------------- |
| username   | admin1111  | 必填         | `用户名且长度为6-12位` |
| password   | 12345678   | 必填         | `密码`                 |

### 响应示例

#### 正确响应示例

```
{
	"success": true,
	"code": 200,
	"message": "登陆成功",
	"data": null
}
```

#### 错误响应示例

```
{
	"success": false,
	"code": 400,
	"message": "密码错误",
	"data": null
}
```

## 注销

### 基本信息

- **接口URL：** `http://81.68.155.14:8080/user/logout`
- **请求方式：** `GET`

### 请求参数

接口请求参数见下表：

### 响应示例

#### 正确响应示例

```json
{
	"success": true,
	"code": 200,
	"message": "注销成功",
	"data": null
}
```

#### 错误响应示例

```json
{
	"success": false,
	"code": 1004,
	"message": "你尚未登录",
	"data": null
}
```

# 开发过程遇到的问题

在进行密码匹配时一直匹配不对，但是当我重启一次电脑过后，就能匹配成功了，再也不能复现如何密码不对的。

# 服务器地址：

81.68.155.14