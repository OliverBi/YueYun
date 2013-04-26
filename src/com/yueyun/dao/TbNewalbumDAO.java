package com.yueyun.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbNewalbum entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.yueyun.dao.TbNewalbum
 * @author MyEclipse Persistence Tools
 */

public class TbNewalbumDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TbNewalbumDAO.class);
	// property constants
	public static final String ALBUM_ID = "albumId";
	public static final String ALBUM_RANK = "albumRank";

	protected void initDao() {
		// do nothing
	}

	public void save(TbNewalbum transientInstance) {
		log.debug("saving TbNewalbum instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbNewalbum persistentInstance) {
		log.debug("deleting TbNewalbum instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbNewalbum findById(java.lang.Integer id) {
		log.debug("getting TbNewalbum instance with id: " + id);
		try {
			TbNewalbum instance = (TbNewalbum) getHibernateTemplate().get(
					"com.yueyun.dao.TbNewalbum", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbNewalbum instance) {
		log.debug("finding TbNewalbum instance by example");
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
		log.debug("finding TbNewalbum instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbNewalbum as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAlbumId(Object albumId) {
		return findByProperty(ALBUM_ID, albumId);
	}

	public List findByAlbumRank(Object albumRank) {
		return findByProperty(ALBUM_RANK, albumRank);
	}

	public List findAll() {
		log.debug("finding all TbNewalbum instances");
		try {
			String queryString = "from TbNewalbum";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbNewalbum merge(TbNewalbum detachedInstance) {
		log.debug("merging TbNewalbum instance");
		try {
			TbNewalbum result = (TbNewalbum) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbNewalbum instance) {
		log.debug("attaching dirty TbNewalbum instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbNewalbum instance) {
		log.debug("attaching clean TbNewalbum instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbNewalbumDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TbNewalbumDAO) ctx.getBean("TbNewalbumDAO");
	}
}