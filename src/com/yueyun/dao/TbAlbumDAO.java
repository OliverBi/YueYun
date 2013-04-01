package com.yueyun.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbAlbum entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.yueyun.dao.TbAlbum
 * @author MyEclipse Persistence Tools
 */

public class TbAlbumDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(TbAlbumDAO.class);
	// property constants
	public static final String ALBUM_NAME = "albumName";
	public static final String ALBUM_IMG_SMALL = "albumImgSmall";
	public static final String ALBUM_IMG_MEDIUM = "albumImgMedium";
	public static final String ALBUM_IMG_LARGE = "albumImgLarge";

	protected void initDao() {
		// do nothing
	}

	public void save(TbAlbum transientInstance) {
		log.debug("saving TbAlbum instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbAlbum persistentInstance) {
		log.debug("deleting TbAlbum instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbAlbum findById(java.lang.String id) {
		log.debug("getting TbAlbum instance with id: " + id);
		try {
			TbAlbum instance = (TbAlbum) getHibernateTemplate().get(
					"com.yueyun.dao.TbAlbum", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbAlbum instance) {
		log.debug("finding TbAlbum instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbAlbum instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbAlbum as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAlbumName(Object albumName) {
		return findByProperty(ALBUM_NAME, albumName);
	}

	public List findByAlbumImgSmall(Object albumImgSmall) {
		return findByProperty(ALBUM_IMG_SMALL, albumImgSmall);
	}

	public List findByAlbumImgMedium(Object albumImgMedium) {
		return findByProperty(ALBUM_IMG_MEDIUM, albumImgMedium);
	}

	public List findByAlbumImgLarge(Object albumImgLarge) {
		return findByProperty(ALBUM_IMG_LARGE, albumImgLarge);
	}

	public List findAll() {
		log.debug("finding all TbAlbum instances");
		try {
			String queryString = "from TbAlbum";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbAlbum merge(TbAlbum detachedInstance) {
		log.debug("merging TbAlbum instance");
		try {
			TbAlbum result = (TbAlbum) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbAlbum instance) {
		log.debug("attaching dirty TbAlbum instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbAlbum instance) {
		log.debug("attaching clean TbAlbum instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbAlbumDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TbAlbumDAO) ctx.getBean("TbAlbumDAO");
	}
}