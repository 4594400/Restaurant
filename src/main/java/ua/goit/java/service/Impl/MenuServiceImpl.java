package ua.goit.java.service.Impl;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.dao.MenuDao;
import ua.goit.java.model.Dish;
import ua.goit.java.model.Menu;
import ua.goit.java.service.MenuService;

import java.util.List;

public class MenuServiceImpl implements MenuService {
    private MenuDao menuDao;

    @Transactional
    @Override
    public int insertMenu(Menu menu) {
        return menuDao.insertMenu(menu);
    }

    @Transactional
    @Override
    public int deleteMenuById(int menuId) {
        return menuDao.deleteMenuById(menuId);
    }

    @Transactional
    @Override
    public List<Menu> selectMenuByName(String name) {
        return menuDao.selectMenuByName(name);
    }

    @Transactional
    @Override
    public List<Menu> selectAllMenu() {
        return menuDao.selectAllMenu();
    }

    @Transactional
    @Override
    public int insertDishToMenu(Dish dish) {
        return menuDao.insertDishToMenu(dish);
    }

    @Transactional
    @Override
    public int deleteDishFromMenuById(int dishId) {
        return menuDao.deleteMenuById(dishId);
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
}
