package TTT;

import com.stylefeng.guns.rest.common.persistence.model.MoocUserT;
import com.stylefeng.guns.rest.common.persistence.dao.MoocUserTMapper;
import TTT.IMoocUserTService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author hxk
 * @since 2019-03-02
 */
@Service
public class MoocUserTServiceImpl extends ServiceImpl<MoocUserTMapper, MoocUserT> implements IMoocUserTService {

}
