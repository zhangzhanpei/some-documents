1、引入 `pagehelper-spring-boot-starter` 依赖   
2、包裹 `Mapper` 查询方法
```java
# 设置页码和每页条数
PageHelper.startPage(pageNum, pageSize);
# 查询方法
List<ArticleWithBLOBs> articles = articleMapper.selectAllArticles();
# 获取分页信息
PageInfo<ArticleWithBLOBs> pageInfo = new PageInfo<>(articles);
```
