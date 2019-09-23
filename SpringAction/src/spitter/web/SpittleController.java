/**
 *
 * @版权 : Copyright (c) 2017-2018 *********公司技术开发部
 * @author: 作者姓名(一般是写姓名的拼音)
 * @E-mail: 邮箱
 * @版本: 1.0
 * @创建日期: 2019年9月23日 上午10:00:06
 * @ClassName SpittleController
 * @类描述-Description:  TODO(这里用一句话描述这个方法的作用)
 * @修改记录:
 * @版本: 1.0
 */

package spitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	private SpittleRepository spittleRepository;
	// 	自动注入
	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}
	@RequestMapping(method = RequestMethod.GET)
	public String spittles(Model model) {
		model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
		return "spittles";
	}
}
