package com.yueyun.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbCollect entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.yueyun.dao.TbCollect
 * @author MyEclipse Persistence Tools
 */

public class TbCollectDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TbCollectDAO.class);
	// property constants
	public static final String COLLECT_TYPE = "collectType";
	public static final String USER_ID = "userId";
	public static final String ALBUM_ID = "albumId";
	public static final String TRACK_ID = "trackId";

	protected void initDao() {
		// do nothing
	}

	public void save(TbCollect transientInstance) {
		log.debug("saving TbCollect instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbCollect persistentInstance) {
		log.debug("deleting TbCollect instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbCollect findById(java.lang.Integer id) {
		log.debug("getting TbCollect instance with id: " + id);
		try {
			TbCollect instance = (TbCollect) getHibernateTemplate().get(
					"com.yueyun.dao.TbCollect", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TbCollect> findByExample(TbCollect instance) {
		log.debug("finding TbCollect instance by example");
		try {
			List<TbCollect> results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TbCollect> findByProperty(String propertyName, Object value) {
		log.debug("finding TbCollect instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbCollect as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TbCollect> findByCollectType(Object collectType) {
		return findByProperty(COLLECT_TYPE, collectType);
	}

	public List<TbCollect> findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List<TbCollect> findByAlbumId(Object albumId) {
		return findByProperty(ALBUM_ID, albumId);
	}

	public List<TbCollect> findByTrackId(Object trackId) {
		return findByProperty(TRACK_ID, trackId);
	}

	@SuppressWarnings("unchecked")
	public List<TbCollect> findAll() {
		log.debug("finding all TbCollect instances");
		try {
			String queryString = "from TbCollect";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbCollect merge(TbCollect detachedInstance) {
		log.debug("merging TbCollect instance");
		try {
			TbCollect result = (TbCollect) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbCollect instance) {
		log.debug("attaching dirty TbCollect instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbCollect instance) {
		log.debug("attaching clean TbCollect instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbCollectDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TbCollectDAO) ctx.getBean("TbCollectDAO");
	}
}