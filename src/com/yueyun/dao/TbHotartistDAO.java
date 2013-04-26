package com.yueyun.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbHotartist entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.yueyun.dao.TbHotartist
 * @author MyEclipse Persistence Tools
 */

public class TbHotartistDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TbHotartistDAO.class);
	// property constants
	public static final String ARTIST_ID = "artistId";
	public static final String ARTIST_RANK = "artistRank";

	protected void initDao() {
		// do nothing
	}

	public void save(TbHotartist transientInstance) {
		log.debug("saving TbHotartist instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbHotartist persistentInstance) {
		log.debug("deleting TbHotartist instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbHotartist findById(java.lang.Integer id) {
		log.debug("getting TbHotartist instance with id: " + id);
		try {
			TbHotartist instance = (TbHotartist) getHibernateTemplate().get(
					"com.yueyun.dao.TbHotartist", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbHotartist instance) {
		log.debug("finding TbHotartist instance by example");
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
		log.debug("finding TbHotartist instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbHotartist as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByArtistId(Object artistId) {
		return findByProperty(ARTIST_ID, artistId);
	}

	public List findByArtistRank(Object artistRank) {
		return findByProperty(ARTIST_RANK, artistRank);
	}

	public List findAll() {
		log.debug("finding all TbHotartist instances");
		try {
			String queryString = "from TbHotartist";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbHotartist merge(TbHotartist detachedInstance) {
		log.debug("merging TbHotartist instance");
		try {
			TbHotartist result = (TbHotartist) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbHotartist instance) {
		log.debug("attaching dirty TbHotartist instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbHotartist instance) {
		log.debug("attaching clean TbHotartist instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbHotartistDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbHotartistDAO) ctx.getBean("TbHotartistDAO");
	}
}