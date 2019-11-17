package nc.Medas.repo;

import nc.Medas.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
}
