package cn.lqm.article.service;

import cn.lqm.article.dao.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import cn.lqm.article.po.Comment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 评论点赞
     * @param id
     */
    public void updateCommentLikenum(String id){
        // 查询条件
        Query query = Query.query(Criteria.where("_id").is(id));
        // 更新条件
        Update update = new Update();
        update.inc("likenum");
        // 参数3：集合的名字或实体类的类型Comment.class
        mongoTemplate.updateFirst(query, update, Comment.class);
    }

    /**
     * 保存一个评论
     * @param comment
     */
    public void saveComment(Comment comment){
        //如果需要自定义主键，可以在这里指定主键；如果不指定主键，MongoDB会自动生成主键
        //设置一些默认初始值
        commentRepository.save(comment);
    }

    /**
     * 更新评论
     * @param comment
     */
    public void updateComment(Comment comment){
        commentRepository.save(comment);
    }

    /**
     * 根据id删除评论
     * @param id
     */
    public void deleteCommentById(String id){
        commentRepository.deleteById(id);
    }

    /**
     * 查询所有评论
     * @return
     */
    public List<Comment> findCommentList(){
        return commentRepository.findAll();
    }

    /**
     * 根据id查询评论
     * @param id
     * @return
     */
    public Comment findCommentById(String id){
        return commentRepository.findById(id).get();
    }

}
