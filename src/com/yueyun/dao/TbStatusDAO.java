package com.yueyun.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbStatus entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.yueyun.dao.TbStatus
 * @author MyEclipse Persistence Tools
 */

public class TbStatusDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TbStatusDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String STATUS_TYPE = "statusType";
	public static final String STATUS_CONTENT = "statusContent";
	public static final String SHARE_TRACK_ID = "shareTrackId";
	public static final String SHARE_ALBUM_ID = "shareAlbumId";

	protected void initDao() {
		// do nothing
	}

	public void save(TbStatus transientInstance) {
		log.debug("saving TbStatus instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbStatus persistentInstance) {
		log.debug("deleting TbStatus instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbStatus findById(java.lang.Integer id) {
		log.debug("getting TbStatus instance with id: " + id);
		try {
			TbStatus instance = (TbStatus) getHibernateTemplate().get(
					"com.yueyun.dao.TbStatus", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbStatus instance) {
		log.debug("finding TbStatus instance by example");
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
		log.debug("finding TbStatus instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbStatus as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByStatusType(Object statusType) {
		return findByProperty(STATUS_TYPE, statusType);
	}

	public List findByStatusContent(Object statusContent) {
		return findByProperty(STATUS_CONTENT, statusContent);
	}

	public List findByShareTrackId(Object shareTrackId) {
		return findByProperty(SHARE_TRACK_ID, shareTrackId);
	}

	public List findByShareAlbumId(Object shareAlbumId) {
		return findByProperty(SHARE_ALBUM_ID, shareAlbumId);
	}

	public List findAll() {
		log.debug("finding all TbStatus instances");
		try {
			String queryString = "from TbStatus";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbStatus merge(TbStatus detachedInstance) {
		log.debug("merging TbStatus instance");
		try {
			TbStatus result = (TbStatus) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbStatus instance) {
		log.debug("attaching dirty TbStatus instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbStatus instance) {
		log.debug("attaching clean TbStatus instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbStatusDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TbStatusDAO) ctx.getBean("TbStatusDAO");
	}
}