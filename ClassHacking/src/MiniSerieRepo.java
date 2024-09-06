

import java.util.List;

public interface MiniSerieRepo {

	public List<Pessoa> findByNameContaining(String name);
	public List<Pessoa> findByOrderByRatingDesc();
}
