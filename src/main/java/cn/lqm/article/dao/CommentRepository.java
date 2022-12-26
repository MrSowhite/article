package cn.lqm.article.dao;

import cn.lqm.article.po.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {

}
