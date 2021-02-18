package servlet;

import java.io.IOException;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MDBProducer
 */
@WebServlet("/MDBProducer")
public class MDBProducer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MDBProducer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		final String QUEUE_LOOKUP = "java:/jms/queue/CODA";
		final String CONNECTION_FACTORY = "ConnectionFactory";
		String tmp = request.getParameter("tmp");
		try {
			Context context = new InitialContext();
			Queue queue = (Queue) context.lookup(QUEUE_LOOKUP);
			QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup(CONNECTION_FACTORY);
			QueueConnection connection = factory.createQueueConnection();
			QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			QueueSender sender = session.createSender(queue);
			TextMessage message = session.createTextMessage();
			message.setText("parametro get -> " + tmp);
			sender.send(message);
			connection.close();
			session.close();

		} catch (Exception gen) {
			gen.printStackTrace();
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
